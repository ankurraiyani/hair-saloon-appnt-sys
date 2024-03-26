import { Component } from '@angular/core';

// Define the Service interface
interface Service {
  title: string;
  type: string;
  price: number;
  duration: number;
  description: string;
  // priceImageUrl: string;
  imageUrl: string;
}

@Component({
  selector: 'app-add-service-to-card',
  templateUrl: './add-service-to-card.component.html',
  styleUrl: './add-service-to-card.component.css',
})
export class AddServiceToCardComponent {
  // Define the services array using the Service interface
  services: Service[] = [
    {
      title: 'Hair Cutting',
      type: 'Hair Cut For Men',
      price: 200,
      duration: 65,
      description: 'Profession hair cut that suits your face shape',
      // priceImageUrl:
      //   'https://t3.ftcdn.net/jpg/03/32/58/10/360_F_332581030_Mfbe3YYwexIWUZQ3qNrSt0XFP35q6fxI.jpg',
      imageUrl:
        'https://www.shutterstock.com/image-photo/male-client-getting-haircut-by-260nw-568819498.jpg',
    },
    {
      title: 'Hair Styling',
      type: 'Hair Style For Women',
      price: 300,
      duration: 20,
      description: 'Professional hair styling to enhance your appearance',
      // priceImageUrl:
      //   'https://t3.ftcdn.net/jpg/03/32/58/10/360_F_332581030_Mfbe3YYwexIWUZQ3qNrSt0XFP35q6fxI.jpg',
      imageUrl:
        'https://www.shutterstock.com/image-photo/male-client-getting-haircut-by-260nw-568819498.jpg',
    },
    {
      title: 'Beard Trimming',
      type: 'Beard Grooming',
      price: 150,
      duration: 20,
      description: 'Expert trimming and shaping for your beard',
      // priceImageUrl:
      //   'https://t3.ftcdn.net/jpg/03/32/58/10/360_F_332581030_Mfbe3YYwexIWUZQ3qNrSt0XFP35q6fxI.jpg',
      imageUrl:
        'https://www.shutterstock.com/image-photo/male-client-getting-haircut-by-260nw-568819498.jpg',
    },
  ];

  serviceCountMap: Map<Service, number> = new Map<Service, number>();
  
  totalAmount: number = 0;

  constructor() {}

  addToCart(service: Service) {
    // Print the data of the selected service to the console
    console.log(service);
  
    // Get the current count of the service from the map
    const count = this.serviceCountMap.get(service);
  
    // If the service is already in the map, increment its count
    if (count !== undefined) {
      this.serviceCountMap.set(service, count + 1);
    } else {
      // If the service is not in the map, add it with a count of 1
      this.serviceCountMap.set(service, 1);
    }
  
    // Increment the total amount
    this.totalAmount += service.price;
  }

  removeItem(product: Service) {
    // Decrease the count of the service in the map
    if (this.serviceCountMap.has(product)) {
      const count = this.serviceCountMap.get(product);
      if (count != undefined && count>1) {
        this.serviceCountMap.set(product, count - 1);
      } else {
        this.serviceCountMap.delete(product);
      }
      this.totalAmount -= product.price;
    }
  }

  addItem(product: Service) {

    const count = this.serviceCountMap.get(product);

    // Increase the count of the service in the map
    if (this.serviceCountMap.has(product) && count!=undefined) {
      this.serviceCountMap.set(product, count + 1);
    } else {
      this.serviceCountMap.set(product, 1);
    }

    this.totalAmount += product.price;
  }

}
