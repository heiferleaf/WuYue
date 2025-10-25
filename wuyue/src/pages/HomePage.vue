<template>
    <div class="container">
        <div class="shadow"></div>

        <TopBar></TopBar>
        <div class="first-page-clock">
            <!-- 艺术标题区域 -->
            <div class="hero-title">
                <div class="title-container">
                    <div class="main-title">
                        <span class="char char-1">万</span>
                        <span class="char char-2">里</span>
                    </div>
                    <div class="sub-title">
                        <span class="char char-3">河</span>
                        <span class="char char-4">山</span>
                    </div>
                    <div class="title-decoration">
                        <div class="decoration-line left"></div>
                        <div class="decoration-text">MAGNIFICENT MOUNTAINS AND RIVERS</div>
                        <div class="decoration-line right"></div>
                    </div>
                    <div class="seal-stamp">
                        <svg viewBox="0 0 100 100" class="seal-svg">
                            <rect x="5" y="5" width="90" height="90" fill="none" stroke="#C8492D" stroke-width="3"/>
                            <text x="50" y="55" text-anchor="middle" font-size="32" fill="#C8492D" font-weight="bold">遊</text>
                        </svg>
                    </div>
                </div>
            </div>

            <div class="quick-card">
                <div 
                    v-for="(item, idx) in mountains" 
                    :key="idx" 
                    @click="scrollToBar(idx)"
                    class="quick-item"
                >
                    <div class="card-background" :style="{ backgroundImage: `url(${item.image})` }"></div>
                    <div class="card-content">
                        <h3 class="card-title" :style="{ color: item.textColor, textShadow: item.textShadow }">
                            {{ item.name }}
                        </h3>
                    </div>
                </div>
            </div>
        </div>

        <div class="next-page-block">
            <div 
                v-for="(mountain, index) in mountains" 
                :key="index"
                ref="bars"
                :class="['bar', index % 2 === 0 ? 'bar-left' : 'bar-right']"
            >
                <div class="bar-image">
                    <img :src="mountain.image" :alt="mountain.name" />
                </div>
                <div class="bar-text">
                    <h3 class="bar-title">{{ mountain.name }}</h3>
                    <p class="bar-description">{{ mountain.description }}</p>
                    <div class="bar-info">
                        <span class="info-item">海拔：{{ mountain.height }}米</span>
                        <span class="info-item">位置：{{ mountain.location }}</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import TopBar from '../components/TopBar.vue';

// 定义数组变量，为每张图配置对应的文字颜色和详细信息
const mountains = ref([
    { 
        name: '恒山景色', 
        height: 1864, 
        image: '/src/assets/恒山.jpeg',
        location: '山西省大同市',
        description: '恒山，人称北岳，与东岳泰山、西岳华山、南岳衡山、中岳嵩山并称为五岳，扬名国内外。恒山悬根独秀，巍峨耸峙，气势雄伟。天峰岭与翠屏峰，是恒山主峰的东西两峰，两峰对峙，浑水中流，地势险要。',
        textColor: '#2C3E42',
        textShadow: '0 2px 4px rgba(255, 255, 255, 0.8), 0 1px 2px rgba(255, 255, 255, 0.6)'
    },
    { 
        name: '衡山景色', 
        height: 2154, 
        image: '/src/assets/衡山.jpeg',
        location: '湖南省衡阳市',
        description: '衡山，又名南岳、寿岳、南山，为中国"五岳"之一。衡山七十二群峰，层峦叠嶂，气势磅礴。素以"五岳独秀"、"宗教圣地"、"文明奥区"、"中华寿岳"著称于世。',
        textColor: '#2D5557',
        textShadow: '0 2px 4px rgba(255, 255, 255, 0.8), 0 1px 2px rgba(255, 255, 255, 0.6)'
    },
    { 
        name: '华山景色', 
        height: 1545, 
        image: '/src/assets/华山.jpeg',
        location: '陕西省渭南市',
        description: '华山，古称"西岳"，雅称"太华山"，为中国五岳之一。华山险居五岳之首，有"奇险天下第一山"的说法。华山有东、西、南、北、中五峰，其中南峰"落雁"是华山最高峰。',
        textColor: '#3D4E50',
        textShadow: '0 2px 4px rgba(255, 255, 255, 0.8), 0 1px 2px rgba(255, 255, 255, 0.6)'
    },
    { 
        name: '嵩山景色', 
        height: 1300, 
        image: '/src/assets/嵩山.jpeg',
        location: '河南省郑州市',
        description: '嵩山，古称"外方"，夏商时称"崇高"、"崇山"，西周时成称为"岳山"，以嵩山为中央左岱右华，定嵩山为中岳，始称"中岳嵩山"。嵩山是中华文明的重要发源地，儒、释、道三教荟萃之地。',
        textColor: '#A84E37',
        textShadow: '0 2px 4px rgba(255, 255, 255, 0.8), 0 1px 2px rgba(255, 255, 255, 0.6)'
    },
    { 
        name: '泰山景色', 
        height: 1300, 
        image: '/src/assets/泰山.jpeg',
        location: '山东省泰安市',
        description: '泰山，又名岱山、岱宗、岱岳、东岳、泰岳，为五岳之一。泰山被古人视为"直通帝座"的天堂，成为百姓崇拜，帝王告祭的神山，有"泰山安，四海皆安"的说法。自秦始皇封禅泰山后，历朝历代帝王不断在泰山封禅和祭祀。',
        textColor: '#2E4A5A',
        textShadow: '0 2px 4px rgba(255, 255, 255, 0.8), 0 1px 2px rgba(255, 255, 255, 0.6)'
    }
])

const bars = ref(null);

// 定义滚动处理函数
const handleScroll = () => {
    const barElements = bars.value;
    if (!barElements) return;
    
    const windowHeight = window.innerHeight;
    const windowCenter = windowHeight / 2;

    barElements.forEach((bar, idx) => {
        const rect = bar.getBoundingClientRect();
        const elementTop = rect.top;
        const elementHeight = rect.height;
        const elementCenter = elementTop + elementHeight / 2;
        
        // 计算距离中心的距离
        const distanceToCenter = Math.abs(elementCenter - windowCenter);
        const maxDistance = windowHeight / 2 + elementHeight / 2;
        
        // 计算进度（0到1）
        const progress = Math.max(0, Math.min(1, 1 - distanceToCenter / maxDistance));
        
        // 获取图片和文字元素
        const imageEl = bar.querySelector('.bar-image');
        const textEl = bar.querySelector('.bar-text');
        
        if (progress > 0.3) { // 当接近中心时才开始显示
            // 文字透明度动画
            textEl.style.opacity = progress;
            
            // 图片滑动动画
            const isLeftImage = idx % 2 === 0;
            const translateX = (1 - progress) * (isLeftImage ? -100 : 100);
            imageEl.style.transform = `translateX(${translateX}px)`;
            imageEl.style.opacity = progress;
            
            // 整体bar的显示
            bar.style.opacity = 1;
        } else {
            // 远离中心时隐藏
            bar.style.opacity = 0;
            imageEl.style.opacity = 0;
            textEl.style.opacity = 0;
        }
    })
}

// 设置一个通过点击快速定位的函数
function scrollToBar(index) {
    if(bars.value[index]) {
        bars.value[index].scrollIntoView({ behavior: 'smooth', block: 'center' });
    }
}

// 实现一个节流的滚动监听效果
function throttle(fn, delay = 100) {
    let lastcall = 0;
    return function(...args) {
        const now = Date.now();
        if(now - lastcall > delay) {
            lastcall = now;
            fn.apply(this, args);
        }
    }
}

// 在挂载时，监听窗口的滚动事件
onMounted(() => {
    window.addEventListener('scroll', throttle(handleScroll, 100));
    // 初始化时触发一次
    handleScroll();
})
</script>

<style>
.shadow {
    position: fixed;
    top: 0;
    left: 0;
    width: 100vw;
    height: 100vh;
    z-index: 10;
    background-color: hsla(0, 0%, 80%, 0.163);
    backdrop-filter: blur(1px);
}

.container {
    min-height: 100vh;
    min-width: 100vw;
    position: relative;
    margin: 0 auto;
    font-family: Arial, sans-serif;
    box-sizing: border-box;
    z-index: 5;
}

.first-page-clock {
    width: 100vw;
    height: 100vh;
    z-index: 20;
    position: relative;
    background-image: url('../assets/home.jpeg');
    background-size: 100% 100%;
    background-position: center top;
    background-repeat: no-repeat;
    border: none;
}

/* 艺术标题样式 */
.hero-title {
    position: absolute;
    top: 40%;
    left: 50%;
    transform: translate(-55%, -55%);
    z-index: 25;
}

.title-container {
    position: relative;
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: -20px;
}

.main-title {
    display: flex;
    align-items: baseline;
    gap: 30px;
    margin-bottom: -30px;
}

.sub-title {
    display: flex;
    align-items: baseline;
    gap: 35px;
    margin-left: 80px;
}

.char {
    font-family: 'STKaiti', 'KaiTi', 'STSong', 'SimSun', serif;
    font-weight: 900;
    color: #2F4F4F;
    background: linear-gradient(180deg, #F5E6D3 10%, #8B7355 40%, #3D2817 100%);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    background-clip: text;
    text-shadow: 
        2px 2px 3px rgba(61, 40, 23, 0.3),
        -1px -1px 2px rgba(255, 255, 255, 0.3),
        0 0 25px rgba(245, 230, 211, 0.2);
    letter-spacing: 10px;
    position: relative;
    display: inline-block;
    animation: float 3s ease-in-out infinite;
    filter: drop-shadow(2px 2px 5px rgba(47, 79, 79, 0.35));
}

.char-1 {
    font-size: 140px;
    transform: rotate(-5deg);
    animation-delay: 0s;
    z-index: 3;
}

.char-2 {
    font-size: 120px;
    transform: rotate(3deg) translateY(15px);
    animation-delay: 0.2s;
    z-index: 2;
}

.char-3 {
    font-size: 160px;
    transform: rotate(2deg) translateY(-10px);
    animation-delay: 0.4s;
    z-index: 4;
    color: #1A0F08;
}

.char-4 {
    font-size: 110px;
    transform: rotate(-4deg) translateY(20px);
    animation-delay: 0.6s;
    z-index: 1;
}

@keyframes float {
    0%, 100% {
        transform: translateY(0) rotate(var(--rotate, 0deg));
    }
    50% {
        transform: translateY(-10px) rotate(var(--rotate, 0deg));
    }
}

.char-1 { --rotate: -5deg; }
.char-2 { --rotate: 3deg; }
.char-3 { --rotate: 2deg; }
.char-4 { --rotate: -4deg; }

/* 装饰线条 */
.title-decoration {
    display: flex;
    align-items: center;
    gap: 20px;
    margin-top: 40px;
    opacity: 0.8;
}

.decoration-line {
    width: 80px;
    height: 2px;
    background: linear-gradient(90deg, transparent, #8B6F47, transparent);
    position: relative;
}

.decoration-line::before {
    content: '';
    position: absolute;
    width: 8px;
    height: 8px;
    background: #8B6F47;
    border-radius: 50%;
    top: 50%;
    transform: translateY(-50%);
}

.decoration-line.left::before {
    left: 0;
}

.decoration-line.right::before {
    right: 0;
}

.decoration-text {
    font-family: 'Georgia', 'Times New Roman', serif;
    font-size: 12px;
    letter-spacing: 3px;
    color: #8B6F47;
    font-weight: 300;
    text-transform: uppercase;
}

/* 印章样式 */
.seal-stamp {
    position: absolute;
    right: -120px;
    bottom: -60px;
    width: 80px;
    height: 80px;
    opacity: 0.9;
    animation: sealAppear 1s ease-out 0.8s both;
}

@keyframes sealAppear {
    0% {
        transform: scale(0) rotate(-180deg);
        opacity: 0;
    }
    100% {
        transform: scale(1) rotate(0deg);
        opacity: 0.9;
    }
}

.seal-svg {
    width: 100%;
    height: 100%;
    filter: drop-shadow(2px 2px 4px rgba(0, 0, 0, 0.3));
}

.quick-card {
    display: flex;
    width: 90%;
    justify-content: space-around;
    align-items: center;
    gap: 16px;
    position: absolute;
    left: 50%;
    transform: translateX(-50%);
    bottom: 80px;
    padding: 0 40px;
}

.quick-item {
    position: relative;
    width: 240px;
    height: 90px;
    border-radius: 16px;
    overflow: hidden;
    cursor: pointer;
    transition: transform 0.3s ease, box-shadow 0.3s ease;
    box-shadow: 0 4px 20px rgba(0, 0, 0, 0.15);
}

.quick-item:hover {
    transform: scale(1.05);
    box-shadow: 0 8px 30px rgba(0, 0, 0, 0.25);
}

.card-background {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-size: 120%;
    background-position: 50% 30%;
    background-repeat: no-repeat;
    filter: brightness(0.90);
    transition: filter 0.3s ease;
}

.quick-item:hover .card-background {
    filter: brightness(1);
}

.card-background::after {
    content: '';
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: linear-gradient(135deg, rgba(255, 255, 255, 0.15) 0%, rgba(255, 255, 255, 0.05) 100%);
}

.card-content {
    position: relative;
    z-index: 2;
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: flex-start;
    background: linear-gradient(135deg, rgba(255, 255, 255, 0.2) 0%, rgba(255, 255, 255, 0.05) 100%);
    backdrop-filter: blur(0.2px);
    -webkit-backdrop-filter: blur(3px);
    box-sizing: border-box;
    padding: 20px;
}

.card-title {
    font-size: 22px;
    font-weight: 2000;
    margin: 0;
    letter-spacing: 1px;
    font-family: 'serif';
}

/* 第二页内容区 */
.next-page-block {
    width: 100vw;
    min-height: 100vh;
    padding: 80px 0;
    box-sizing: border-box;
    border: none;
    background-image: url('../assets/second-page.jpeg');
    background-repeat: repeat-y;
    background-size: 100% auto;
    background-position: center top;
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 200px;
}

/* Bar 样式 - 雾状背景 */
.bar {
    width: 85%;
    max-width: 1200px;
    min-height: 400px;
    display: flex;
    align-items: center;
    gap: 60px;
    padding: 60px;
    box-sizing: border-box;
    background: radial-gradient(ellipse at center, rgba(40, 40, 40, 0.85) 0%, rgba(20, 20, 20, 0.75) 100%);
    backdrop-filter: blur(10px);
    -webkit-backdrop-filter: blur(10px);
    border-radius: 20px;
    box-shadow: 
        0 8px 32px rgba(0, 0, 0, 0.3),
        inset 0 1px 0 rgba(255, 255, 255, 0.1);
    opacity: 0;
    transition: opacity 0.3s ease;
    overflow: hidden;
    position: relative;
    z-index: 20;
}

.bar::before {
    content: '';
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background: 
        radial-gradient(circle at 20% 30%, rgba(255, 255, 255, 0.05) 0%, transparent 50%),
        radial-gradient(circle at 80% 70%, rgba(255, 255, 255, 0.03) 0%, transparent 50%);
    pointer-events: none;
}

/* 左图右文布局 */
.bar-left {
    flex-direction: row;
}

/* 右图左文布局 */
.bar-right {
    flex-direction: row-reverse;
}

/* 图片容器 */
.bar-image {
    flex: 0 0 45%;
    height: 350px;
    border-radius: 12px;
    overflow: hidden;
    box-shadow: 0 8px 24px rgba(0, 0, 0, 0.4);
    opacity: 0;
    transition: transform 0.6s ease-out, opacity 0.6s ease-out;
}

.bar-image img {
    width: 100%;
    height: 100%;
    object-fit: cover;
    display: block;
}

/* 文字容器 */
.bar-text {
    flex: 1;
    color: #E8E8E8;
    opacity: 0;
    transition: opacity 0.8s ease-out;
}

.bar-title {
    font-size: 32px;
    font-weight: 700;
    margin: 0 0 20px 0;
    color: #F5E6D3;
    font-family: 'STKaiti', 'KaiTi', 'STSong', serif;
    letter-spacing: 2px;
    text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
}

.bar-description {
    font-size: 16px;
    line-height: 1.8;
    margin: 0 0 30px 0;
    color: #D0D0D0;
    font-family: 'PingFang SC', 'Microsoft YaHei', sans-serif;
    text-align: justify;
}

.bar-info {
    display: flex;
    gap: 30px;
    margin-top: 20px;
}

.info-item {
    font-size: 14px;
    color: #B8B8B8;
    padding: 8px 16px;
    background: rgba(255, 255, 255, 0.1);
    border-radius: 20px;
    border: 1px solid rgba(255, 255, 255, 0.15);
    font-family: 'PingFang SC', 'Microsoft YaHei', sans-serif;
}

/* 响应式调整 */
@media (max-width: 1024px) {
    .bar {
        flex-direction: column !important;
        padding: 40px;
    }
    
    .bar-image {
        flex: 0 0 auto;
        width: 100%;
        height: 300px;
    }
}
</style>