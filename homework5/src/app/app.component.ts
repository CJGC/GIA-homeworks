import { Component } from '@angular/core';
import { User } from './data/entity/user';

@Component({
  selector: 'hom-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'homework5';

  public users : Array<User>;

  constructor() { }

  ngOnInit() { 
      this.users = new Array();
      let names = ["Juan","Alberto","Fernando","Carlos","Mariana",
        "Luisa","Melisa","Carolina","Andres","Sergio"];
      
      let usernames = ["Juanx","Albe","Fern123","Lokart","Mari",
        "Luisita777","Melissa","Karolin99","Andres23","Sergio74"];

      let emails = ["juan@me.co","albe@me.co","fer@me.co", "carl@me.co",
        "mari@me.co","luisa@me.co","melisn@me.co","karito@me.co",
        "adnres@me.co","serg@me.co"];

      for (let i = 0; i<10; i++) {
          let user = new User();
          user.setId(i+1);
          user.setName(names[i]);
          user.setUsername(usernames[i]);
          user.setEmail(emails[i]);
          user.setPassword("#23FZ3#");
          this.users.push(user);
      }
  }

}
