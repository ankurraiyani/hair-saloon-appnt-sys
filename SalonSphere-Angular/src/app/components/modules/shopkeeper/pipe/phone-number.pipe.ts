import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'phoneNumber'
})
export class PhoneNumberPipe implements PipeTransform {

  transform(value: string): string {
    if (!value || value.length !== 10) {
      return value; // return the original value if it's not a valid 10-digit phone number
    }

    const part1 = value.slice(0, 3);
    const part2 = value.slice(3, 6);
    const part3 = value.slice(6);

    return `+91 ${part1}-${part2}-${part3}`; // format as "123-456-7890"
  }
}