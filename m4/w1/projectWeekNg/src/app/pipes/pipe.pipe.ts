import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'pipe'
})
export class PipePipe implements PipeTransform {

  transform(value: string, ...args: unknown[]): unknown {
    var maiuscolo = value.toUpperCase()
    return null;
  }

}
