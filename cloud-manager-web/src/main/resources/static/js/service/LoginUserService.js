//提交数据到服务器的接口
app.service("LoginUserService",function ($http) {
        this.getloginName=function () {
            return $http.get("/User/user/loginName")
        }
})
