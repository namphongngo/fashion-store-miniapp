<template>

  <div
    class="p-3"
    style="
    height:100%;
    overflow-y:auto;
    padding-bottom:90px;
    "
  >

    <h4 class="fw-bold mb-4">

      Chi tiết đơn hàng

    </h4>

    <!-- INFO -->

    <div
      v-if="bill"

      class="
      card
      border-0
      shadow-sm
      mb-4
      "
    >

      <div class="card-body">

        <p>

          <strong>Mã đơn:</strong>

          #{{ bill.id }}

        </p>

        <p>

          <strong>Khách hàng:</strong>

          {{ bill.customerName }}

        </p>

        <p>

          <strong>Số điện thoại:</strong>

          {{ bill.phone }}

        </p>

        <p>

          <strong>Địa chỉ:</strong>

          {{ bill.address }}

        </p>

        <p>

          <strong>Trạng thái:</strong>

          <span class="badge bg-dark">

            {{ bill.status }}

          </span>

        </p>

      </div>

    </div>

    <!-- TOTAL -->

    <div
      v-if="bill"

      class="
      card
      border-0
      shadow-sm
      "
    >

      <div class="card-body">

        <h5 class="fw-bold">

          Tổng tiền:
          {{ formatPrice(bill.totalAmount) }}

        </h5>

      </div>

    </div>

  </div>

</template>

<script setup>

import {
  ref,
  onMounted
}
from "vue";

import {
  useRoute
}
from "vue-router";

import api
from "../services/api";

const route = useRoute();

const bill = ref(null);

const loadBill = async () => {

  const response =
  await api.get(

    "/bills/" +
    route.params.id
  );

  bill.value =
  response.data;

  console.log(response.data);
};

const formatPrice = (price) => {

  if (!price) {

    return "0 đ";
  }

  return new Intl.NumberFormat("vi-VN")
    .format(price) + " đ";
};

onMounted(() => {

  loadBill();

});

</script>