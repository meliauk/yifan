<template>
    <div class="masonry"> 
        <div class="item"> 
          <div class="item_content content-lar"> 1 我最大 </div> 
        </div> 
        <div class="item"> 
          <div class="item_content content-sma"> 2 我最小 </div> 
        </div>
        <div class="item"> 
          <div class="item_content content-mid"> 3 我中等 </div> 
        </div>
        <div class="item"> 
          <div class="item_content content-sma"> 4 我最小 </div> 
        </div>
        <div class="item"> 
          <div class="item_content content-mid"> 5 我中等 </div> 
        </div>
        <div class="item"> 
          <div class="item_content content-lar"> 6 我最大 </div> 
        </div>
        <div class="item"> 
          <div class="item_content content-sma"> 7 我最小 </div> 
        </div>
        <div class="item"> 
          <div class="item_content content-lar"> 8 我最大 </div> 
        </div>
        <div class="item"> 
          <div class="item_content content-lar"> 9 我最大 </div> 
        </div>
        <div class="item"> 
          <div class="item_content content-sma"> 10 我最小 </div> 
        </div>
        <div class="item">
          <div class="item_content content-mid"> 11 我中等 </div> 
        </div>
        <div class="item"> 
          <div class="item_content content-mid"> 12 我中等 </div> 
        </div>
        <!-- more items --> 
    </div>
</template>

<script>
    export default {
        name: "timeRec"
    }
</script>

<style scoped>
   .masonry { 
  -moz-column-count:3; /* Firefox */
  -webkit-column-count:3; /* Safari 和 Chrome */
  column-count:3;
  -moz-column-gap: 2em;
  -webkit-column-gap: 2em;
  column-gap: 2em;
  width: 70%;
  margin:2em auto;
}
.item { 
  padding: 2em;
  margin-bottom: 2em;
  -webkit-column-break-inside: avoid;
  break-inside: avoid;
  background: rgba(54, 193, 228,0.8);
  color: #fff;
  border-radius: 10px;
  text-align: center;
}
.item .content-lar {
  height: 200px;
}
.item .content-mid {
  height: 100px;
}
.item .content-sma {
  height: 50px;
}
@media screen and (max-width: 800px) { 
  .masonry { 
    column-count: 2; /* two columns on larger phones */
  } 
} 
@media screen and (max-width: 500px) { 
  .masonry { 
    column-count: 1; /* two columns on larger phones */
  }
}
</style>