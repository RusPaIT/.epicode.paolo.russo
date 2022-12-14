export interface AuthResponse {

    accessToken: string,
    user: {
        email: string,
        name: string,
        id: number
    }
}


export interface RegisterRequest {
    email: string,
    password: string,
    name: string
}

export interface LoginRequest {
    email: string,
    password: string
}

