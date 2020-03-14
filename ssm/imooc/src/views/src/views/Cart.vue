<template>
  <div class="cart-header">
    <div class="cart-header-warp clearfix">
      <div class="cart-title left clearfix">
        <h1 class="left">我的购物车</h1>
        <div class="left js-number-box-cart">
          共
          <span class="js-coures-num">{{shoppingCart.length}}</span>门，已选择
          <span class="js-choice-num">{{checkedProjects.length}}</span>门
        </div>
      </div>
    </div>
    <div class="cart-body" id="cartBody" style="margin-top: 20px;">
      <el-table
        :data="shoppingCart"
        stripe
        height="600px"
        @selection-change="handleSelectionChange"
        style="padding-top:40px;padding-left:60px;"
      >
        <el-table-column type="selection" width="40px"></el-table-column>
        <el-table-column prop="project_cover" width="250px">
          <template slot-scope="scope">
            <a :href="'/detail?id='+scope.row.project_id">
              <img
                :src="$store.state.server_baseurl+scope.row.project_cover"
                width="200"
                height="150"
              />
            </a>
          </template>
        </el-table-column>
        <el-table-column prop="project_title" label="标题" width="450px">
          <template slot-scope="scope">
            <a :href="'/detail?id='+scope.row.project_id">{{scope.row.project_title}}</a>
          </template>
        </el-table-column>
        <el-table-column prop="project_price" label="价格" width="120px"></el-table-column>
        <el-table-column label="操作" width="120px">
          <template slot-scope="scope">
            <el-button
              type="danger"
              icon="el-icon-delete"
              @click="deletePorject(scope.row.project_id)"
            >删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <div class="cart-body-bot js-cart-body-bot">
        <div class="clearfix cart-body-bot-box">
          <div class="right">
            <ul class="clearfix">
              <li class="li-2" style="margin-right: -50px;">
                <div class="topdiv">总计金额：</div>
                <div class="price price-red clearfix">
                  <em>￥</em>
                  <span class="jsAltogether">{{total}}</span>
                </div>
              </li>
              <li class="li-3" style="margin-right: 60px;">
                <span class="btn js-go-confrim" @click="pay">结算</span>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      checkedProjects: [],
      total: 0
    };
  },
  created() {
    this.loadData();
  },
  computed: {
    shoppingCart() {
      return this.$store.state.projects;
    }
  },
  methods: {
    pay() {
      let ids = [],
        prices = [];
      for (let index in this.checkedProjects) {
        ids.push(this.checkedProjects[index].project_id);
        prices.push(this.checkedProjects[index].project_price);
      }
      let param = {
        'ids': ids.join(","),
        'prices': prices.join(",")
      };
      this.axios
        .get("/purchase_history/add", param)
        .then(res => {
          console.log(res.data);
          if ("12138" == res.data.code) {
            this.$message({
              message: "购买成功",
              type: "success"
            });
            for(let index in this.shoppingCart){
              this.shoppingCart.splice(index,1);
            }
          } else {
            this.$message.error(res.data.msg);
          }
        })
        .catch(error => {
          console.log(error);
        });
    },
    deletePorject(projectId) {
      this.axios
        .get("shopping_cart/delete/" + projectId)
        .then(res => {
          console.log(res.data);
          if ("12138" == res.data.code) {
            this.$store.commit("saveProjects", res.data.data);
            this.$message({
              message: "删除成功",
              type: "success"
            });
          } else {
            this.$message.error(res.data.msg);
          }
        })
        .catch(error => {
          console.log(error);
        });
    },
    loadData() {
      let self = this;
      this.axios
        .get("/shopping_cart/my")
        .then(res => {
          // self.shoppingCart = res.data.data;
          this.$store.commit("saveProjects", res.data.data);
          // console.log(this.$store.state.projects)
        })
        .catch(error => {
          console.log(error);
        });
    },
    handleSelectionChange(val) {
      this.checkedProjects = val;
      this.total = 0;
      for (let i in this.checkedProjects) {
        this.total += Number(this.checkedProjects[i].project_price);
      }
    }
  }
};
</script>


<style scoped>
.cart-body .cart-body-bot .li-3 .btn {
  margin-left: 38px;
  float: right;
  padding: 13px 32px;
  color: #fff;
  font-size: 16px;
  color: #fff;
  cursor: pointer;
  font-weight: 200;
  background: teal;
  border-radius: 4px;
}
.cart-body .cart-body-bot .li-3 {
  padding-top: 24px;
}
.cart-body .cart-body-bot li {
  float: left;
}
em {
  font-style: normal;
}
.cart-body .cart-body-bot .li-2 .price {
  font-size: 16px;
  color: teal;
  line-height: 24px;
  font-weight: 700;
}
.cart-body .cart-body-bot .li-2 .topdiv {
  margin-top: 24px;
  font-size: 12px;
  color: #07111b;
  line-height: 24px;
}
.cart-body .cart-body-bot .li-2 {
  width: 150px;
}
.cart-body .right {
  float: right !important;
}
.cart-body .item {
  height: 90px;
  padding: 24px 0;
  border-bottom: 1px solid #d9dde1;
}
.l {
  float: left;
}
.cart-header {
  background-color: #e3e6e9;
  /* background: url(../assets/cart/cart-header-bg.jpg) repeat-x left bottom; */
}
.cart-header .cart-header-warp {
  width: 1104px;
  height: 120px;
  line-height: 120px;
  margin-left: auto;
  margin-right: auto;
  font-size: 14px;
}

.cart-header .cart-title {
  color: #4d555d;
  font-weight: 200;
  font-size: 14px;
}
.cart-header .left {
  float: left;
  font-weight: bold;
}
.cart-header .right {
  float: right;
}
.cart-header .cart-title h1 {
  font-size: 32px;
  line-height: 115px;
  margin-right: 25px;
  color: teal;
  font-weight: bold;
}
.cart-body {
  margin-top: 40px;
  width: 1152px;
  padding: 0 36px 32px;
  background-color: #fff;
  margin-top: -40px;
  margin-left: auto;
  margin-right: auto;
  box-shadow: 0 8px 16px 0 rgba(7, 17, 27, 0.1);
  border-radius: 8px;
  box-sizing: border-box;
}
.main {
  height: 800px;
}
a {
  color: #07111b;
}
a:hover {
  color: teal;
}
</style>