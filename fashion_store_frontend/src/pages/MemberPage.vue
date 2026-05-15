<template>

  <div
    class="p-3"
    style="
    height:100%;
    overflow-y:auto;
    padding-bottom:90px;
    "
  >

    <!-- PROFILE -->

    <div
      class="
      card
      border-0
      shadow-sm
      rounded-4
      mb-4
      "
    >

      <div class="card-body text-center">

        <img
          src="https://i.pravatar.cc/200"

          class="rounded-circle mb-3"

          style="
          width:100px;
          height:100px;
          object-fit:cover;
          "
        />

        <h4 class="fw-bold">
          Phong
        </h4>

        <p class="text-secondary mb-0">
          Nike Member
        </p>

      </div>

    </div>

    <!-- MENU -->

    <div
      class="
      card
      border-0
      shadow-sm
      rounded-4
      "
    >

      <div class="card-body p-0">

        <!-- ORDERS -->

        <router-link
          to="/orders"

          class="
          d-flex
          justify-content-between
          align-items-center
          p-3
          border-bottom
          text-decoration-none
          text-dark
          "
        >

          <div
            class="
            d-flex
            align-items-center
            gap-3
            "
          >

            <i class="bi bi-bag fs-5"></i>

            <span>
              Đơn hàng của tôi
            </span>

          </div>

          <i class="bi bi-chevron-right"></i>

        </router-link>

        <!-- FAVORITES -->

        <router-link
          to="/favorites"

          class="
          d-flex
          justify-content-between
          align-items-center
          p-3
          border-bottom
          text-decoration-none
          text-dark
          "
        >

          <div
            class="
            d-flex
            align-items-center
            gap-3
            "
          >

            <i class="bi bi-heart fs-5"></i>

            <span>
              Sản phẩm yêu thích
            </span>

          </div>

          <i class="bi bi-chevron-right"></i>

        </router-link>

        <!-- LOGOUT -->

        <div
          class="
          d-flex
          justify-content-between
          align-items-center
          p-3
          "
        >

          <div
            class="
            d-flex
            align-items-center
            gap-3
            "
          >

            <i
              class="
              bi bi-box-arrow-right
              fs-5
              text-danger
              "
            ></i>

            <span class="text-danger">

              Đăng xuất

            </span>

          </div>

        </div>

      </div>

    </div>

  </div>

</template>