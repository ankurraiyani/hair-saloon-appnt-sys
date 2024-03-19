import { Component } from '@angular/core';

// Define the Service interface
interface Service {
  title: string;
  type: string;
  price: number;
  duration: string;
  description: string;
  priceImageUrl: string;
  imageUrl: string;
}

@Component({
  selector: 'app-add-service-to-card',
  templateUrl: './add-service-to-card.component.html',
  styleUrl: './add-service-to-card.component.css'
})
export class AddServiceToCardComponent {

  // Define the services array using the Service interface
  services: Service[] = [
    {
      title: 'Hair Cutting',
      type: 'Hair Cut For Men',
      price: 200,
      duration: '30 min',
      description: 'Profession hair cut that suits your face shape',
      priceImageUrl: 'https://t3.ftcdn.net/jpg/03/32/58/10/360_F_332581030_Mfbe3YYwexIWUZQ3qNrSt0XFP35q6fxI.jpg',
      imageUrl: 'https://www.shutterstock.com/image-photo/male-client-getting-haircut-by-260nw-568819498.jpg'
    },
    {
      title: 'Hair Styling',
      type: 'Hair Style For Women',
      price: 300,
      duration: '45 min',
      description: 'Professional hair styling to enhance your appearance',
      priceImageUrl: 'https://t3.ftcdn.net/jpg/03/32/58/10/360_F_332581030_Mfbe3YYwexIWUZQ3qNrSt0XFP35q6fxI.jpg',
      imageUrl: 'https://www.shutterstock.com/image-photo/male-client-getting-haircut-by-260nw-568819498.jpg'
    },
    {
      title: 'Beard Trimming',
      type: 'Beard Grooming',
      price: 150,
      duration: '20 min',
      description: 'Expert trimming and shaping for your beard',
      priceImageUrl: 'https://t3.ftcdn.net/jpg/03/32/58/10/360_F_332581030_Mfbe3YYwexIWUZQ3qNrSt0XFP35q6fxI.jpg',
      imageUrl: 'https://www.shutterstock.com/image-photo/male-client-getting-haircut-by-260nw-568819498.jpg'
    }
  ];

  cart: Service[] = []; // Initialize cart as an empty array of Services

  totalAmount: number=0;

  constructor() { }

  addToCart(service: Service) {
    // Print the data of the selected service to the console
    console.log(service);
    this.totalAmount = this.totalAmount + service.price;
    this.cart.push(service);
  }

}
