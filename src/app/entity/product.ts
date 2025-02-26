
export class Product {

  public id: number;
  public name: string;
  public color: string;
  public category: string;
  public price:number;

  constructor(id: number, name: string, color: string, category: string, price: number) {
    this.id = id;
    this.name = name;
    this.color = color;
    this.category = category;
    this.price = price;
  }
}
