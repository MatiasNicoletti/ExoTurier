import { User } from './User';
import { Excursion } from './Excursion';

export class Purchase{
    id:number;
    date: Date;
    totalPrice: number;
    excursion: Excursion;
    user: User;
}