import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue'; // 如果是 Vue 2，请改用: import vue from '@vitejs/plugin-vue2';

export default defineConfig({
  appType: 'spa', // 对应 historyApiFallback
  plugins: [vue()],
  server: {
    host: '0.0.0.0',   // 对应 host: '0.0.0.0'
    port: 8080,        // 你的 ws URL 里用了 8080，这里固定端口
    // Vite 默认 HMR 开启、无需 hot: true
    hmr: {
      // 对应你原先的 ws path '/ws'
      // 其他如协议/主机/端口保持自动推断即可
      path: '/ws',
      // 如需强制协议/主机，可按需打开：
      // protocol: 'ws',
      // host: 'localhost',
      // port: 8080,
    },
    // allowedHosts 在 Vite 中不需要，Vite 默认无 Host 校验
    proxy: {
      '/api': {
        target: 'http://localhost:7122',
        changeOrigin: true,
        secure: false,
        ws: true, // 让 WebSocket 也走代理
      },
    },
    // compress: false 在 Vite 无对应项，开发环境默认不压缩
  },
});