import {OnInit } from '@angular/core';

export class User implements OnInit {
    public id : number;
    public username : String;
    public password : String;
    public name : String;
    public email : String;

    constructor() { 
    }

    ngOnInit() { 
        this.id = 1;
        this.username = new String("");
        this.password = new String("");
        this.name = new String("");
        this.email = new String("");        
    }

    public getId(): number {
        return this.id;
    }

    public setId(id: number): void {
        this.id = id;
    }

    public getUsername(): String {
        return this.username;
    }

    public setUsername(username: String): void {
        this.username = username;
    }

    public getPassword(): String {
        return this.password;
    }

    public setPassword(password: String): void {
        this.password = password;
    }

    public getName(): String {
        return this.name;
    }

    public setName(name: String): void {
        this.name = name;
    }

    public getEmail(): String {
        return this.email;
    }

    public setEmail(email: String): void {
        this.email = email;
    }
    
}