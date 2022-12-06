import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, ReplaySubject, Subject, tap } from 'rxjs';
import { Photo } from './photo';

@Injectable({
  providedIn: 'root'
})
export class PhotoService {

  photos:Photo[] = []

  // dataSubj = new Subject<boolean>() //emette i next()
  dataSubj = new ReplaySubject<boolean>() //emette i next(), quando viene fatto il subscribe viene letto l'ultimo valore inviato (quindi i component quando fanno il subscribe leggeranno i dati anche se il next lo avevamo inviato nella pagina precedente)
  dataObs = this.dataSubj.asObservable() //può essere ascoltato per i next

  constructor(private http:HttpClient) { }

  getDataObs() {
    return this.dataObs
  }

  getData() {
    return this.http.get<Photo[]>("http://localhost:3000/photos").pipe(catchError((err)=>{
      this.dataSubj.next(false)
      throw new Error("Lettura GET fallita")
    }));
  }

  getPhotos() {
    return this.photos
  }

  fetchData() {
    // fetch("http://localhost:3000/photos").then(res=>res.json()).then(res=>{
    //   this.photos = res
    // })
    this.getData().subscribe((res)=>{
      this.photos = res
      this.dataSubj.next(true);
    })
  }


  delete(id:number) {
    console.log("ELIMINA", id);

    this.http.delete("http://localhost:3000/photos/"+id).pipe(catchError(err=>{
      this.dataSubj.next(false);
      throw new Error("Eliminazione fallita")
    })).subscribe(res=>{
      this.photos = this.photos.filter(p=>p.id!=id)
      this.dataSubj.next(true)
    })
  }




}
