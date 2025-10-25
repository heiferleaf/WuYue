<template>
    <div class="topbar">
      <div class="logo">WuYue</div>
      <div class="mountain-bars">
        <div
          v-for="(item, idx) in navItems"
          :key="item.name"
          class="mountain-bar-item"
          :class="{ actived: idx === activedIdx, hovered: idx === hoverIdx }"
          @click="handleClick(idx)"
          @mouseenter="hoverIdx = idx"
          @mouseleave="hoverIdx = -1"
          :ref="(el) => { if (el) barRefs[idx] = el }"
        >
          {{ item.name }}
        </div>
        <div class="slider" :style="sliderStyle"></div>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref, computed, nextTick, onMounted, onBeforeUpdate } from 'vue'
  import { useRouter } from 'vue-router'
  
  const router = useRouter()
  const navItems = [
    { name: '首页', path: '/' },
    { name: '恒山', path: '/' },
    { name: '衡山', path: '/' },
    { name: '华山', path: '/' },
    { name: '嵩山', path: '/' },
    { name: '泰山', path: '/' }
  ]
  
  const activedIdx = ref(-1)
  const hoverIdx = ref(-1)
  // 使用对象而不是响应式数组
  const barRefs = {}
  
  function handleClick(idx) {
    activedIdx.value = idx
    router.push(navItems[idx].path)
  }
  
  const sliderStyle = computed(() => {
    const idx = activedIdx.value
    const el = barRefs[idx]
    
    if (el) {
      const { offsetLeft, offsetWidth } = el
      return {
        left: (offsetLeft + offsetWidth / 6) + 'px',
        width: offsetWidth * 2 / 3 + 'px',
        opacity: 1
      }
    }
    return {
        left: barRefs[0] ? (barRefs[0].offsetLeft + barRefs[0].offsetWidth / 6) + 'px' : '0px',
        width: barRefs[0] ? (barRefs[0].offsetWidth * 2 / 3) + 'px' : '0px',
        opacity: 1
    }
  })
  
  onMounted(() => {
    if (barRefs[0]) {
      activedIdx.value = 0
    }
  })
  </script>
  
  <style scoped>
.topbar {
  width: 100%;
  height: 60px;
  background: #ffffff;
  display: flex;
  align-items: center;
  font-family: 'PingFang SC', 'Microsoft YaHei', 'Helvetica Neue', 'Arial', sans-serif;
  position: fixed;
  top: 0;
  left: 0;
  z-index: 100;
  box-shadow: 0 1px 0 0 rgba(0, 0, 0, 0.06);
}

.logo {
  font-weight: 500;
  font-size: 16px;
  letter-spacing: 0.5px;
  margin-left: 40px;
  color: #333333;
  font-family: 'PingFang SC', 'Microsoft YaHei', sans-serif;
}

.mountain-bars {
  display: flex;
  align-items: center;
  margin-left: 60px;
  position: relative;
  height: 100%;
  gap: 4px;
}

.mountain-bar-item {
  position: relative;
  padding: 0 20px;
  height: 60px;
  display: flex;
  align-items: center;
  font-size: 15px;
  cursor: pointer;
  color: #999999;
  transition: 
    color 0.25s ease,
    font-size 0.2s ease;
  font-weight: 400;
  user-select: none;
  font-family: 'PingFang SC', 'Microsoft YaHei', sans-serif;
  letter-spacing: 0.3px;
}

.mountain-bar-item.actived {
  color: #CA573B;
  font-size: 16px;
  font-weight: 500;
  text-shadow: 0 0 0.5px currentColor;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

.mountain-bar-item.hovered:not(.actived) {
  color: #666666;
}

.mountain-bar-item:not(.actived):hover {
  color: #666666;
}

.slider {
  position: absolute;
  bottom: 0;
  height: 3px;
  border-radius: 1.5px 1.5px 0 0;
  background: #CA573B;
  transition:
    left 0.3s cubic-bezier(0.4, 0, 0.2, 1),
    width 0.3s cubic-bezier(0.4, 0, 0.2, 1),
    opacity 0.25s ease;
  opacity: 1;
  z-index: 2;
}
</style>