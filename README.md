# Coffeeland

- five-elephant: Play scala application. Defines `Five Elephant` coffee shop API. 
- the-barn: Play scala application. Defines `The Barn` coffee shop API.
- starbucks: Play scala application. Defines `starbucks` - maybe a - coffee shop API.
- core: Shareable library between API applications above.

## Usage

Launch Five Elephant application. Listening for HTTP on `localhost:9001`:

```bash
$ sbt c-five-elephant/run
```

Launch The Barn application. Listening for HTTP on `localhost:9002`:

```bash
$ sbt c-the-barn/run
```

Launch Starbucks application. Listening for HTTP on `localhost:9003`:

```bash
$ sbt c-starbucks/run
``` 

To access the APIs:

```bash
$ curl http://localhost:9001/coffee-shop/cappuccino
Enjoy your fancy Cappuccino! Made by Five Elephant.

$ curl http://localhost:9002/coffee-shop/cappuccino
Enjoy your fancy Cappuccino! Made by The Barn.

$ curl http://localhost:9003/coffee-shop/cappuccino
Good luck with your Cappuccino! Made by Starbucks.
```