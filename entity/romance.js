import {title} from "process";

export class Romance {
  id
  title
  description
  price

  constructor(id, title, description, price) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.price = price;
  }
}
