export interface Post {

  id: number;
  title: string;
  body: string;
  active: boolean;
  type: string;
  author: string;
}


export interface User {
  id: number;
  name: string;
  email: string;
}
