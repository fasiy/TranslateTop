App({
    onLaunch: function () {
        console.log('App Launch')
        //获取登录状态
        this.login();
    },
    onShow: function () {
        console.log('App Show')
    },
    onHide: function () {
        console.log('App Hide')
    },
    globalData: {
        hasLogin: false
    },
    login: function(){
      //先从storage中获取登录token
      if(wx.getStorageSync('token')){
        return;
      }
      wx.login({
        success:function(res){
          if(res.code){
            console.log("code是：" + res.code);
            wx.request({
              url: 'https://url',
              data: {code: res.code},
              method: 'POST',
              success: function(){
                
              }
            })
          }
        }
      })

    }
});