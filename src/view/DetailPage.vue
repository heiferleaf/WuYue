<template>
  <div class="mount-tai-page">
    <!-- 全屏英雄背景 -->
    <div class="hero-background">
      <div class="background-overlay"></div>
    </div>

    <!-- 卷轴内容区 -->
    <div class="scroll-container">
      <div class="ancient-scroll">
        <div class="scroll-content">
          <div class="scroll-text">
            {{ scrollContent }}
          </div>
        </div>
      </div>
    </div>
    <div class="button-group">
      <button
        class="nav-button natural-btn"
        @click="scrollToSection('natural')"
      >
        <span class="btn-icon">🏔️</span>
        自然景观
      </button>
      <button
        class="nav-button cultural-btn"
        @click="scrollToSection('cultural')"
      >
        <span class="btn-icon">🏯</span>
        人文景观
      </button>
    </div>

    <!-- 自然景观区 -->
    <section id="natural" class="landscape-section natural-section">
      <div class="section-title">
        <h2>自然奇观</h2>
        <div class="title-decoration"></div>
      </div>

      <div class="landscape-list">
        <div
          v-for="(item, index) in naturalScenes"
          :key="'natural-' + index"
          class="landscape-item"
          :class="{ reverse: index % 2 !== 0 }"
        >
          <div class="image-container">
            <img :src="item.image" :alt="item.title" class="landscape-image" />
            <div class="image-overlay"></div>
          </div>
          <div class="content-container">
            <h3 class="item-title">{{ item.title }}</h3>
            <p class="item-description">{{ item.description }}</p>
            <div class="decoration-line"></div>
          </div>
        </div>
      </div>
    </section>

    <!-- 人文景观区 -->
    <section id="cultural" class="landscape-section cultural-section">
      <div class="section-title">
        <h2>人文瑰宝</h2>
        <div class="title-decoration"></div>
      </div>

      <div class="landscape-list">
        <div
          v-for="(item, index) in culturalScenes"
          :key="'cultural-' + index"
          class="landscape-item"
          :class="{ reverse: index % 2 !== 0 }"
        >
          <div class="image-container">
            <img :src="item.image" :alt="item.title" class="landscape-image" />
            <div class="image-overlay"></div>
          </div>
          <div class="content-container">
            <h3 class="item-title">{{ item.title }}</h3>
            <p class="item-description">{{ item.description }}</p>
            <div class="decoration-line"></div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
export default {
  name: "MountTaiPage",
  data() {
    return {
      scrollContent: `泰山，位于华北大平原的东侧，面积426平方公里，主峰玉皇顶海拔高度为1545(1532)米。泰山融雄伟壮丽的自然风光与悠久灿烂的历史文化于一体，她是中国首例世界文化与自然双遗产、世界地质公园、首批全国文明风景旅游区、首批国家5A级旅游景区。泰山以气势雄伟著称于世,形体高大，拔地通天，基础宽广，安稳厚重。景色千姿百态，悬崖峭壁，深沟峡谷，奇峰怪石，林海松涛，泉飞鸟鸣 并形成旭日东升、云海玉盘、碧霞宝光、晚霞夕照等独特的自然奇观。泰山自古就有神山、圣山、“五岳独尊”的称誉，是四海一统、国泰民安的象征。数千年来，封建帝王封禅告祭，文人名士登临抒怀，儒释道观和合共处，平民百姓顶礼膜拜，使之成为中华民族的精神家园。更有三大断裂、科马提岩、醉心石等奇特地质构造，岱庙、南天门、碧霞祠等巧夺天工的古代建筑杰作，秦刻石、经石峪、唐摩崖等历代名贵石刻,秦松、汉柏、唐槐等珍稀古树名木 这些,有机地将自然景观与人文景观融合为一体。一条从山下直通极顶长达九公里的中轴线，凭藉7000级石阶把天、地、人贯穿为一个完整的序列，从而成为人类投入大自然的通天之路。 泰山，一座一万年堆积的自然宝库；泰山，一轴百万年续展的历史长卷；泰山，一阙七千阶谱写的朝天神曲；泰山，一幢五千年镌刻的文化丰碑。泰山，中华民族精神的家园，欢迎您到泰山来！`,

      naturalScenes: [
        {
          title: "旭日东升",
          description:
            "是岱顶的奇观之一，破晓时分，晨曦由灰暗变成淡黄、橘红，漫天彩霞与云海融为一体，火红的太阳从地平线升起，霞光染透天际。",
          image: "/src/assets/detail/1/xuri.jpg",
        },
        {
          title: "云海玉盘",
          description:
            "多见于夏秋雨后，大量水蒸气蒸发上升，在海拔1500米左右的岱顶，可见白云平铺万里，犹如巨大玉盘悬浮天地间，泰山周围群山被云雾吞没，几座山头露出云端，宛如仙境。 ",
          image: "/src/assets/detail/1/yunhai.jpg",
        },
        {
          title: "晚霞夕照",
          description:
            "雨过天晴、夕阳西下时，漫步泰山极顶，可见西天残云如峰似峦，金光穿云破雾直泻人间，云峰被镶嵌上一层金灿灿的亮边，闪烁着奇珍异宝般的光辉",
          image: "/src/assets/detail/1/wanxia.jpg",
        },
        {
          title: "十八盘",
          description:
            "是泰山登山盘道中最险要的一段，全长约1公里，共有1600多级台阶，陡峭的石阶如天梯般直通南天门，两侧峰峦夹峙，云雾缭绕时更显险峻。",
          image: "/src/assets/detail/1/shibapan.jpg",
        },
        {
          title: "仙人桥",
          description:
            "由三块巨石天然叠成桥状，下临深渊，桥长约10米，宽仅1米左右，站在桥上可感受大自然的鬼斧神工。",
          image: "/src/assets/detail/1/xianrenqiao.jpg",
        },
      ],

      culturalScenes: [
        {
          title: "中天门",
          description:
            "正处泰山半腰，游人至此上山的路已走了半程。中天门是泰山中、西路交汇处，也是泰山索道的起点。在这里无论仰望山顶还是俯览山下，皆令人心旷神怡。到中天门后，您可根据自己的体力及时间等条件选择继续攀登或者乘坐缆车。中天门建有数家宾馆,如果您留恋这里的风景,可在此食宿尽情领略这里的山水风光。",
          image: "/src/assets/detail/1/zhongtianmen.jpg",
        },
        {
          title: "天贶殿",
          description:
            "天贶殿是岱庙最伟大的建筑，建于中国北宋大中祥符元年(1008年)，它采用的中国古代建筑中最高规格的“九五”之制建造的。一般来说，只有王宫的正殿才可以使用“九五”之制。天贶殿辉煌壮丽，与北京故宫太和殿、曲阜孔庙大成殿并列为中国古代三大宫殿",
          image: "/src/assets/detail/1/tiankudian.jpg",
        },
        {
          title: "岱庙",
          description:
            "位于泰山南麓，是古代帝王祭祀泰山神的地方，也是中国现存规模最大、保存最完整的古代建筑群之一。庙内有众多古建筑、碑刻和古树名木，如宋天贶殿、汉柏凌寒等，展现了深厚的历史文化底蕴。",
          image: "/src/assets/detail/1/daimiao.jpg",
        },
        {
          title: "碧霞祠",
          description:
            "是泰山上的一座道教古建筑，始建于宋代，现存建筑为明代重建。碧霞祠红墙青瓦，在云雾中若隐若现，与周围的山色相融，殿内供奉着碧霞元君，香火旺盛。",
          image: "/src/assets/detail/1/bixiaci.jpg",
        },
      ],
    };
  },
  methods: {
    scrollToSection(sectionId) {
      const element = document.getElementById(sectionId);
      if (element) {
        element.scrollIntoView({
          behavior: "smooth",
          block: "start",
        });
      }
    },
  },
};
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

.mount-tai-page {
  min-height: 100vh;
  font-family: "SimSun", "STKaiti", serif;
  color: #333;
  position: relative;
}

/* 英雄背景 */
.hero-background {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100vh;
  background: linear-gradient(135deg, #1a2f3f 0%, #2c5530 100%);
  z-index: -1;
}

.hero-background::before {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-image: url("../assets/detail/background.png");
  background-size: cover;
}

.background-overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: radial-gradient(
      circle at 20% 50%,
      rgba(120, 119, 65, 0.3) 0%,
      transparent 50%
    ),
    radial-gradient(
      circle at 80% 20%,
      rgba(139, 69, 19, 0.2) 0%,
      transparent 50%
    );
}

/* 卷轴容器 */
.scroll-container {
  min-height: 84vh;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 2rem;
  margin-left: auto;
  margin-right: auto;
}

.ancient-scroll {
  /* background: linear-gradient(135deg, #f5e8c8 0%, #e8d8b5 100%); */
  background-image: url("../assets/detail/1/taishan.png");
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;

  width: 90%;
  height: 700px;

  position: relative;
  transform: translateY(0);
  animation: float 6s ease-in-out infinite;
}

.ancient-scroll::before {
  content: "";
  position: absolute;
  top: 10px;
  left: 10px;
  right: 10px;
  bottom: 10px;
  pointer-events: none;
}

@keyframes float {
  0%,
  100% {
    transform: translateY(0px);
  }
  50% {
    transform: translateY(-10px);
  }
}

.scroll-content {
  text-align: center;

  display: flex;
  align-items: center;
  justify-content: center;

  width: 70%;
  height: 50%;
  overflow-y: auto;
  margin-left: auto;
  margin-right: auto;
  margin-top: 250px;

  position: relative;
}

.scroll-title {
  font-size: 3.5rem;
  font-weight: normal;
  color: #8b4513;
  margin-bottom: 2rem;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2);
  letter-spacing: 0.5rem;
}

.scroll-text {
  font-size: 1.6rem;
  line-height: 2;
  color: #5d4037;
  text-align: center;
  text-indent: 2em;
  font-family: "STKaiti", serif;

  position: absolute;
  top: 0px;
}

/* 按钮组 */
.button-group {
  display: flex;
  gap: 2rem;
  justify-content: center;
  flex-wrap: wrap;
}

.nav-button {
  padding: 1rem 2rem;
  font-size: 1.1rem;
  border: none;
  cursor: pointer;
  transition: all 0.3s ease;
  font-family: inherit;
  position: relative;
  overflow: hidden;
  display: flex;
  align-items: center;
  gap: 0.5rem;

  background: transparent;
}

.nav-button::before {
  content: "";
  position: absolute;
  top: 0;
  left: -100%;
  width: 100%;
  height: 100%;
  background: linear-gradient(
    90deg,
    transparent,
    rgba(255, 255, 255, 0.3),
    transparent
  );
  transition: left 0.5s;
}

.nav-button:hover::before {
  left: 100%;
}

.natural-btn {
  /* background: linear-gradient(135deg, #2e7d32 0%, #4caf50 100%); */
  background-image: url("../assets/detail/button.png");
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;

  color: white;
}

.natural-btn:hover {
  transform: translateY(-2px);
}

.cultural-btn {
  /* background: linear-gradient(135deg, #5d4037 0%, #8d6e63 100%); */
  background-image: url("../assets/detail/button.png");
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;

  color: white;
}

.cultural-btn:hover {
  transform: translateY(-2px);
}

.btn-icon {
  font-size: 1.3rem;
}

/* 景观区域 */
.landscape-section {
  padding: 6rem 2rem;
  position: relative;
}

.natural-section {
  background: transparent;
}

.cultural-section {
  background: transparent;
}

.section-title {
  text-align: center;
  margin-bottom: 4rem;
}

.section-title h2 {
  font-size: 2.5rem;
  color: #5d4037;
  margin-bottom: 1rem;
  font-weight: normal;
}

.title-decoration {
  width: 100px;
  height: 3px;
  background: linear-gradient(90deg, transparent, #8b4513, transparent);
  margin: 0 auto;
}

/* 景观列表 */
.landscape-list {
  max-width: 1200px;
  margin: 0 auto;
}

.landscape-item {
  display: flex;
  align-items: center;
  gap: 4rem;
  margin-bottom: 6rem;
  opacity: 0;
  transform: translateY(30px);
  animation: fadeInUp 0.8s ease forwards;
}

.landscape-item:nth-child(1) {
  animation-delay: 0.1s;
}
.landscape-item:nth-child(2) {
  animation-delay: 0.3s;
}
.landscape-item:nth-child(3) {
  animation-delay: 0.5s;
}

.landscape-item.reverse {
  flex-direction: row-reverse;
}

@keyframes fadeInUp {
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

.image-container {
  flex: 1;
  position: relative;
  border-radius: 10px;
  overflow: hidden;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);
  transition: transform 0.3s ease;
}

.image-container:hover {
  transform: scale(1.02);
}

.landscape-image {
  width: 100%;
  height: 400px;
  object-fit: cover;
  display: block;
}

.image-overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: linear-gradient(
    45deg,
    rgba(139, 69, 19, 0.1) 0%,
    transparent 50%
  );
}

.content-container {
  flex: 1;
  padding: 2rem;
}

.item-title {
  font-size: 2rem;
  font-weight: bold;

  color: #5d4037;
  margin-bottom: 1rem;
  position: relative;
}

.item-title::after {
  content: "";
  position: absolute;
  bottom: -5px;
  left: 0;
  width: 50px;
  height: 2px;
  background: #8b4513;
}

.item-description {
  font-size: 1.4rem;
  font-weight: bold;
  line-height: 1.8;
  color: #666;
  text-align: justify;
}

.decoration-line {
  width: 100px;
  height: 1px;
  background: linear-gradient(90deg, #8b4513, transparent);
  margin-top: 2rem;
}

/* 响应式设计 */
@media (max-width: 768px) {
  .scroll-container {
    padding: 1rem;
  }

  .ancient-scroll {
    padding: 2rem 1.5rem;
  }

  .scroll-title {
    font-size: 2.5rem;
  }

  .scroll-text {
    font-size: 1rem;
  }

  .button-group {
    flex-direction: column;
    align-items: center;
  }

  .nav-button {
    width: 100%;
    max-width: 250px;
  }

  .landscape-item {
    flex-direction: column;
    gap: 2rem;
  }

  .landscape-item.reverse {
    flex-direction: column;
  }

  .content-container {
    padding: 1rem 0;
  }
}
</style>
