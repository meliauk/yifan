<template>
  <div id="app">
      <!-- <Player></Player> -->
      <router-view/>
  </div>
</template>

<script>
    import Player from 'zw-player'
    export default {
        name: 'App',
        components: {
            Player
        }
    }
</script>
<style>
*{
    list-style: none;
    text-decoration: none;
    height: auto;
    font-family: 'Avenir', Helvetica, Arial, sans-serif;

}
.music_list{height: auto;}
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
   color: #2c3e50;
   margin: 0;
   padding: 0;
    width: 100%;
}
    a:hover{
        text-decoration: none;
    }
    a:link{
        text-decoration: none;
    }
</style>
