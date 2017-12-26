Page({
  data: {
    inputShowed: false,
    inputVal: "",
    keyWords: ['五星级', '价格高', '剩余时间多'],
    classifications: [{ id: 0, src: '../../images/nav_icon_01.png', title: '星级'},
      { id: 1, src: '../../images/nav_icon_02.png', title: '价格' },
      { id: 2, src: '../../images/nav_icon_03.png', title: '时间' }, { id: 3, src: '../../images/nav_icon_04.png', title: '加急' }],
    curNavId: 0,
    curIndex: 0,
    colors: ['red', 'orange', 'yellow', 'green', 'purple'],
    orders: [{ id: 0, coverpath: '../../images/recommend_img_01.png', subject: '标题一', price: '200', message: '点击查看详情'},
      { id: 1, coverpath: '../../images/recommend_img_02.png', subject: '标题二', price: '200', message: '点击查看详情' },
      { id: 2, coverpath: '../../images/recommend_img_03.png', subject: '标题三', price: '200', message: '点击查看详情' },
      { id: 3, coverpath: '../../images/recommend_img_04.png', subject: '标题四', price: '200', message: '点击查看详情' },
      { id: 4, coverpath: '../../images/recommend_img_05.png', subject: '标题五', price: '200', message: '点击查看详情' }
    ]
      },
  showInput: function () {
    this.setData({
      inputShowed: true
    });
  },
  hideInput: function () {
    this.setData({
      inputVal: "",
      inputShowed: false
    });
  },
  clearInput: function () {
    this.setData({
      inputVal: ""
    });
  },
  inputTyping: function (e) {
    this.setData({
      inputVal: e.detail.value
    });
  },
  switchTab: function (e) {
    let id = e.currentTarget.dataset.id,
    index = parseInt(e.currentTarget.dataset.index)
    this.curIndex = parseInt(e.currentTarget.dataset.index)
    console.log(e)
    var that = this
    this.setData({
      curNavId: id,
      curIndex: index,
    })
  }
});