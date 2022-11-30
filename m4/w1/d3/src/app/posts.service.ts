/*import { Injectable } from '@angular/core';
import { Post } from './models/posts';

@Injectable({
  providedIn: 'root'
})
export class PostsService {

  constructor() { }
}


export async function getPosts(){
  let res = await fetch("https://localhost:3000/posts");
  let post: Posts[]  = await res.json();
  return post;
}

export async function getPostsFilter(active:boolean){
  (await getPosts()).filter((e) => {
    if(e.active == active){
      return true;
    } else {
      return false;
    }
    return getPosts();
});
}*/

import { Post } from "./models/posts"

export function getPosts() {
  let f = fetch("http://localhost:3000/posts")
  let r = f.then((res): Promise<Post[]> => {
    if (res.ok) {
      return res.json()
    }
    throw new Error("Lettura fallita")
  })

  r.catch((err) => {
    console.log("Errore", err.getMessage())
  })

  return r;
}


export function getPostsFiltered(a:boolean) {
  let t = getPosts().then((res) => {
    let arrFiltrato = res.filter((e) => {return (e.active == a)})
    return arrFiltrato
  })
  return t;
}
