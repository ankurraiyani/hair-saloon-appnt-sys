import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'shopkeeperDuration'
})
export class ShopkeeperDurationPipe implements PipeTransform {

  transform(value: number): string {
    if (!value || isNaN(value)) {
      return '';
    }

    const hours = Math.floor(value / 60);
    const minutes = value % 60;

    if (hours === 0) {
      return `${minutes} minute${minutes !== 1 ? 's' : ''}`;
    } else if (minutes === 0) {
      return `${hours} hour${hours !== 1 ? 's' : ''}`;
    } else {
      return `${hours} hour${hours !== 1 ? 's' : ''} ${minutes} minute${minutes !== 1 ? 's' : ''}`;
    }
  }
}
