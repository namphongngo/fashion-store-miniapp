<template>

  <div
    class="
    bg-white
    border-top
    d-flex
    justify-content-around
    align-items-center
    "
    style="
    height:70px;
    position:absolute;
    bottom:0;
    width:100%;
    "
  >

    <!-- TRANG CHỦ -->

    <router-link
      to="/"
      class="
      text-center
      text-dark
      text-decoration-none
      "
    >

      <i class="bi bi-house fs-5"></i>

      <div class="small">
        Trang chủ
      </div>

    </router-link>

    <!-- DANH MỤC -->

    <router-link
      to="/category"
      class="
      text-center
      text-dark
      text-decoration-none
      "
    >

      <i class="bi bi-grid fs-5"></i>

      <div class="small">
        Danh mục
      </div>

    </router-link>

    <!-- GIỎ HÀNG -->

    <router-link
      to="/cart"
      class="
      text-center
      text-dark
      text-decoration-none
      "
    >

      <i class="bi bi-cart fs-5"></i>

      <div class="small">
        Giỏ hàng
      </div>

    </router-link>

    <!-- THÀNH VIÊN -->

    <router-link
      to="/member"
      class="
      text-center
      text-dark
      text-decoration-none
      "
    >

      <i class="bi bi-person fs-5"></i>

      <div class="small">
        Thành viên
      </div>

    </router-link>

  </div>

</template>