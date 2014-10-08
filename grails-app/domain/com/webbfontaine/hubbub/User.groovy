package com.webbfontaine.hubbub

class User {

    String loginId
    String password
    Date dateCreated
    static hasOne = [profile: Profile]

    static constraints = {
        loginId nullable: false, size: 3..20
        password nullable: false, size: 6..10, validator: { passwd, user ->
            passwd != user.loginId
        }
        profile nullable: true
    }

    static hasMany = [posts: Post, tags: Tag, following : User]

}
