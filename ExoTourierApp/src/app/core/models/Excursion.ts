import { City } from './City';
import { Purchase } from './Purchase';

export class Excursion{
    id: number;
    name: string;
    description: string;
    price: number;
    place: string;
    isActive: boolean;
    city: City;
    purchases: Purchase[];
}