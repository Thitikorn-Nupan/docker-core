import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Romance} from "../entity/romance";

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  private romancesObserve: Observable<Romance[]>;

  constructor(private http: HttpClient) {
    // initial observable
    this.romancesObserve = new Observable<Romance[]>((observer) => {
      this.http.get("http://localhost:3001/api/reads").subscribe((res: any) => {
        // then publishes data
        observer.next(res.data)
      });
    });


  }

  public getRomances(): Observable<Romance[]> {
    return this.romancesObserve
  }

}
