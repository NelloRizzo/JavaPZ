import { ArrayPipe } from './array.pipe';

describe('ArrayPipe', () => {
  it('create an instance', () => {
    const pipe = new ArrayPipe();
    expect(pipe).toBeTruthy();
  });
});
