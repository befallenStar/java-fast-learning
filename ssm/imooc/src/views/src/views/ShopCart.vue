<template>
  <div class="shop-main">
    <div class="cart-header">
      <div class="cart-header-warp clearfix">
        <div class="cart-title left clearfix">
          <h1 class="left">我的购物车</h1>

          <div class="left js-number-box-cart">
            共
            <span class="js-coures-num">2</span>门，已选择
            <span class="js-choice-num">2</span>门
          </div>
        </div>
        <!-- 购物车广告位 -->
        <div id="orderCartBanner"></div>
        <div class="right">
          <div class="clearfix">
            <span class="left">
              <a class="js-myorderbtn myorder-history" href="/myorder">我的订单历史</a>
            </span>
            <span class="left num js-order-num" style="display: none;"></span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {};
</script>
<style>
.cart-header {
  height: 160px;
  background-color: #e3e6e9;
  background: url(../assets/shopcart/cart-header-bg.jpg) repeat-x left bottom;
}
</style>