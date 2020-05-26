import { Purchase } from './Purchase';

export class User{
    id: number;
    email: string;
    isActive: boolean;
    firstname: string;
    surname: string;
    password: string;
    purchases: Purchase[];
}