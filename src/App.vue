<template>
  <div id="app">
    <TopBar></TopBar>
    <router-view />
  </div>
</template>

<script setup>
import TopBar from './components/TopBar.vue';

</script>

<style>
#app {
  padding : 0;
  margin : 0;

  width: 100%;
}
</style>