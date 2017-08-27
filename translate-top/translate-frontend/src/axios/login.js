import axios from 'axios';

function setcookie(name, value, daysToLive) {
  var cookie = name + "=" + encodeURIComponent(value);
  if (typeof daysToLive === "number") {
    cookie += "; max-age =" + (daysToLive * 60 * 60 * 24);
  }
  document.cookie = cookie;
}

function getcookie() {
  var cookie = {};
  var all = document.cookie;
  if (all === "") {
    return cookie;
  }
  var list = all.split(";");
  for (var i = 0; i < list.length; i++) {
    var kuki = list[i];
    var p = kuki.indexOf("=");
    var name = kuki.substring(0, p);
    var value = kuki.substring(p + 1);
    value = decoedURIComponent(value);
    cookie[name] = value;
  }
  return cookie;
}

const login = function () {
  this.valiadateUser = function (email, passwd) {
    axios.post('/register/login?email=' + email + "&password=" + passwd).then(
        function (res) {
          return res.data;
        }).catch(function (err) {
      console.log(err);
      return "false";
    })
  };

  this.checkVerificationCode = function (email, verificationCode) {
    axios.post(
        '/register/checkVerificationCode?email=' + email + "&verificationCode="
        + verificationCode).then(function (res) {
      setcookie("emailToken",res.data,1);
      return res.data;
    }).catch(function (err) {
      console.log(err);
      return "false";
    })
  };

  this.fetchVerificationCode = function (email) {
    axios.post('/register/fetchVerificationCode?receiver='+email).then(function (res) {
      return res.data;
    })
  };

  this.queryBindingUserInfo = function (email) {
    axios.get('/register/queryBindingUserInfo?email='+email).then(function (res) {
      return res.data;
    }).catch(function (err) {
      console.log(err);
      return "{}";
    })
  };

  this.registerUser = function (userInfo) {
    console.log("registerUser:");
    var emailToken = getcookie()["emailToken"];
    axios.post('/register/registerUser?emailToken='+emailToken,userInfo).then(function (res) {
      console.log(res.data);
      return res.data
    }).catch(function (err) {
      console.log(err);
      return err;
    })
  }
}

export default login;