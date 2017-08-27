<template>
  <Form ref="formInline" :model="formInline" :rules="ruleInline" inline>
    <Form-item prop="user">
      <Input type="text" v-model="formInline.user" placeholder="Username">
      <Icon type="ios-person-outline" slot="prepend"></Icon>
      </Input>
    </Form-item>
    <Form-item prop="password">
      <Input type="password" v-model="formInline.password" placeholder="Password">
      <Icon type="ios-locked-outline" slot="prepend"></Icon>
      </Input>
    </Form-item>
    <Form-item>
      <Button type="primary" @click="handleSubmit('formInline')">登录</Button>
    </Form-item>
  </Form>
</template>
<script>
  import login from '../../axios/login.js';
  export default {
    data () {
      return {
        formInline: {
          user: '',
          password: ''
        },
        ruleInline: {
          user: [
            { required: true, message: '请填写用户名', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '请填写密码', trigger: 'blur' },
            { type: 'string', min: 6, message: '密码长度不能小于6位', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      handleSubmit(form) {
        this.$refs[form].validate((valid) => {
          if (valid) {
            var res = login.valiadateUser(form.user,form.password);
            if(res === 'true'){
              this.$Message.success('登陆成功!');
              return;
            }
            this.$Message.success('登陆失败!');
          } else {
            this.$Message.error('表单验证失败!');
          }
        })
      }
    }
  }
</script>
