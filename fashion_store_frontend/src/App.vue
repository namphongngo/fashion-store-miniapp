<template>

  <div class="phone-frame">

    <div class="app bg-light">

      <router-view />

      <BottomNav />

    </div>

  </div>

</template>

<script setup>

import BottomNav
from "./components/BottomNav.vue";

</script>

<style>

body{

  background:#d9d9d9;

  margin:0;

  font-family:Arial;
}

.phone-frame{

  width:430px;

  height:820px;

  margin:20px auto;

  background:black;

  border-radius:50px;

  padding:14px;

  box-shadow:
  0 20px 50px rgba(0,0,0,0.3);
}

.app{

  width:100%;

  height:100%;

  border-radius:40px;

  overflow:hidden;

  position:relative;
}

</style>