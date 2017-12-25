Page({
  data: {
    inputShowed: false,
    inputVal: "",
    keyWords: ['五星级', '价格高', '剩余时间多'],
    classifications: [{ id: 0, src: '../../images/orders.png', title: '星级'},
      { id: 1, src: '../../images/orders.png', title: '价格' },
      { id: 2, src: '../../images/orders.png', title: '时间' }, { id: 3, src: '../../images/orders.png', title: '加急' }],
    curNavId: 0,
    curIndex: 0,
    colors: ['red', 'orange', 'yellow', 'green', 'purple'],
    orders: [{ id: 0, coverpath: '../../images/orders.png', subject: '标题一', price: '200', message: '点击查看详情'},
      { id: 1, coverpath: '../../images/orders.png', subject: '标题一', price: '200', message: '点击查看详情' },
      { id: 2, coverpath: '../../images/orders.png', subject: '标题一', price: '200', message: '点击查看详情' },
      { id: 3, coverpath: '../../images/orders.png', subject: '标题一', price: '200', message: '点击查看详情' },
      { id: 4, coverpath: '../../images/orders.png', subject: '标题一', price: '200', message: '点击查看详情' }
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