
export class User {
    idUser: number;
    username: string;
    password: string;
    type: string;



    // tslint:disable-next-line:max-line-length
    constructor(userId: number, username: string, password: string, type: string) {
        this.idUser = userId;
        this.username = username;
        this.password = password;
        this.type = type;
    }

}