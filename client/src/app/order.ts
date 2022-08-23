import { Article } from "./article";

export class Order {
    id:number;
    date:Date = new Date();
    reference:string;
    articles :Article[];
}
