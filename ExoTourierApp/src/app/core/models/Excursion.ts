import { City } from './City';
import { Purchase } from './Purchase';

export class Excursion {
  id: number;
  name: string;
  description: string;
  price: number;
  place: string;
  isActive: boolean;
  gridClass: string;
  imagePathMain: string;
  imagePathSecondary: string;
  city: City;
  purchases: Purchase[];
}
