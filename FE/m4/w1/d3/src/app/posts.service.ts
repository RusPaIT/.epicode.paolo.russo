/*import { Post } from "./models/posts"

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
*/

import { Post } from "src/app/models/posts";

var posts:Post[] =[]

export function fetchPost() {
  fetch("http://localhost:3000/posts").then(res => res.json()).then((res: Post[]) => {posts = res})
}

export function getPosts() {
  return posts
}

export function getPostsFiltered(a:boolean) {
  let arrFiltrato = posts.filter((e) => {return (e.active == a)})
  return arrFiltrato;
}

export function attivaPost (id: number) {
  let indexPostDaAttivare = posts.findIndex((e) => {
    return e.id == id
  })
  if(!indexPostDaAttivare){
    throw new Error("Post non trovato")
  }
  posts[indexPostDaAttivare].active = true
  fetch("http://localhost:3000/posts/" + id, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json"
    },
    body:JSON.stringify(posts[indexPostDaAttivare])
  })

  /*.then((res): Promise<Post> => {
    if(res.ok) {
      return res.json()
    }
    throw new Error("modifica fallita")
  }).catch((err) => {
    console.log("Err", err.getMessage());
  })
  */
  }

  export function disattivaPost (id: number) {
    let indexPostDaAttivare = posts.findIndex((e) => {
      return e.id == id
    })
    if(!indexPostDaAttivare){
      throw new Error("Post non trovato")
    }
    posts[indexPostDaAttivare].active = false
    fetch("http://localhost:3000/posts/" + id, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json"
      },
      body:JSON.stringify(posts[indexPostDaAttivare])
    })
  }
