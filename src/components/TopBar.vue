<template>
  <div class="topbar">
    <div class="logo">WuYue</div>
    <div class="mountain-bars">
      <div
        v-for="(item, idx) in navItems"
        :key="item.name"
        class="mountain-bar-item"
        :class="{ actived: idx === activedIdx, hovered: idx === hoverIdx }"
        @click="handleClick(idx, $event)"
        @mouseenter="hoverIdx = idx"
        @mouseleave="hoverIdx = -1"
        :ref="(el) => { if (el) barRefs[idx] = el }"
      >
        <!-- 水波纹效果 -->
        <div
          v-for="ripple in ripples.filter(r => r.idx === idx)"
          :key="ripple.id"
          class="ripple"
          :style="{
            left: ripple.x + 'px',
            top: ripple.y + 'px'
          }"
        />

        <!-- 悬停云雾效果 -->
        <div v-if="idx === hoverIdx && idx !== activedIdx" class="cloud-effects">
          <div class="cloud cloud-1"></div>
          <div class="cloud cloud-2"></div>
        </div>

        <!-- 选中墨迹效果 -->
        <div v-if="idx === activedIdx" class="ink-spread"></div>

        <!-- 文字阴影（选中时） -->
        <div v-if="idx === activedIdx" class="text-shadow"></div>

        <span class="nav-item-text">
          {{ item.name }}
        </span>
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
  { name: '名山详情', path: '/detail' },
  { name: '文化与传说', path: '/culture' },
  { name: '旅行指南', path: '/travel' }
]

const activedIdx = ref(-1)
const hoverIdx = ref(-1)
const barRefs = {}
const ripples = ref([])

function handleClick(idx, event) {
  activedIdx.value = idx
  
  // 创建水波纹效果
  const rect = event.currentTarget.getBoundingClientRect()
  const x = event.clientX - rect.left
  const y = event.clientY - rect.top
  const id = Date.now()
  
  ripples.value.push({ id, x, y, idx })
  
  // 移除过期的水波纹
  setTimeout(() => {
    ripples.value = ripples.value.filter(r => r.id !== id)
  }, 800)
  
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
  font-weight: 600;
  font-size: 16px;
  letter-spacing: 0.5px;
  margin-left: 40px;
  background: linear-gradient(135deg, #CA573B 0%, hsl(15, 78%, 74%) 100%);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
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
  transition: all 0.3s ease;
  font-weight: 400;
  user-select: none;
  font-family: 'PingFang SC', 'Microsoft YaHei', sans-serif;
  letter-spacing: 0.3px;
  overflow: visible;
}

/* 文字样式 - 修正颜色 */
.nav-item-text {
  position: relative;
  z-index: 2;
  display: inline-block;
  color: #999999;
  font-weight: 400;
  transition: all 0.4s cubic-bezier(0.4, 0, 0.2, 1);
}

.mountain-bar-item.actived .nav-item-text {
  background: linear-gradient(135deg, #CA573B 0%, #D67C5F 50%, #CA573B 100%);
  background-size: 200% auto;
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
  animation: textFloat 2s ease-in-out infinite;
  font-weight: 600;
  letter-spacing: 0.5px;
  font-size: 16px;
}

.mountain-bar-item.hovered:not(.actived) .nav-item-text {
  color: #666666;
  transform: translateY(-1px);
}

/* 水波纹效果 - 修正为朱红色 */
.ripple {
  position: absolute;
  width: 0;
  height: 0;
  border-radius: 50%;
  background: radial-gradient(circle, rgba(202, 87, 59, 0.3) 0%, transparent 70%);
  transform: translate(-50%, -50%);
  pointer-events: none;
  animation: rippleEffect 0.8s ease-out forwards;
  z-index: 1;
}

/* 悬停云雾效果 - 修正为朱红色 */
.cloud-effects {
  pointer-events: none;
}

.cloud {
  position: absolute;
  background: radial-gradient(ellipse, rgba(202, 87, 59, 0.15) 0%, transparent 70%);
  filter: blur(3px);
  pointer-events: none;
  animation: cloudFloat 2s ease-out forwards;
}

.cloud-1 {
  top: 20px;
  left: 10px;
  width: 40px;
  height: 8px;
}

.cloud-2 {
  bottom: 22px;
  right: 12px;
  width: 35px;
  height: 7px;
  animation-delay: 0.3s;
}

/* 选中墨迹效果 - 修正为朱红色 */
.ink-spread {
  position: absolute;
  top: 50%;
  left: 50%;
  width: 60px;
  height: 60px;
  background: radial-gradient(circle, rgba(202, 87, 59, 0.1) 0%, transparent 70%);
  transform: translate(-50%, -50%);
  pointer-events: none;
  filter: blur(8px);
  animation: inkSpread 1s ease-out forwards;
  z-index: 1;
}

/* 文字阴影（选中时） */
.text-shadow {
  position: absolute;
  bottom: 18px;
  left: 50%;
  transform: translateX(-50%);
  width: 70%;
  height: 3px;
  background: radial-gradient(ellipse, rgba(202, 87, 59, 0.12) 0%, transparent 70%);
  filter: blur(2px);
  pointer-events: none;
  z-index: 1;
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

/* 动画定义 */
@keyframes textFloat {
  0%, 100% {
    transform: translateY(0);
  }
  50% {
    transform: translateY(-3px);
  }
}

@keyframes rippleEffect {
  0% {
    width: 0;
    height: 0;
    opacity: 0.5;
  }
  100% {
    width: 100px;
    height: 100px;
    opacity: 0;
  }
}

@keyframes cloudFloat {
  0% {
    transform: translateX(0) translateY(0);
    opacity: 0;
  }
  10% {
    opacity: 0.15;
  }
  90% {
    opacity: 0.15;
  }
  100% {
    transform: translateX(30px) translateY(-5px);
    opacity: 0;
  }
}

@keyframes inkSpread {
  0% {
    transform: translate(-50%, -50%) scale(0.8);
    opacity: 0;
  }
  50% {
    opacity: 0.4;
  }
  100% {
    transform: translate(-50%, -50%) scale(1.2);
    opacity: 0;
  }
}
</style>