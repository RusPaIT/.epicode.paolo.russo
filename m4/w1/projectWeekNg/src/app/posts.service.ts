import { Post } from "src/app/models/posts";

var posts:Post[] =[]
var det: Post[] = []

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


  export function eliminaPost (id: number) {
    let indexPostDaEliminare = posts.findIndex((e) => {
      return e.id == id
    })
    if(!indexPostDaEliminare){
      throw new Error("Post non trovato")
    }
    posts[indexPostDaEliminare].active = true
    fetch("http://localhost:3000/posts/" + id, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json"
      },
      body:JSON.stringify(posts[indexPostDaEliminare])
    })
    }

    export function dettaglio(id: number) {

      let detPost = posts.findIndex((post) => {
          return post.id == id;
      });

      det = [];

      return det.push(posts[detPost])
  }

  export function getDettaglio() {
      return det;
  }
