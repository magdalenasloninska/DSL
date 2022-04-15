# DSL (*domain specific language*) for accountants and financiers

The app provides an easy way to perform various money operations (comparison, addition, multiplication, conversion etc.) using Scala's unique implicit technology. To achieve this simplified notation we introduce currency symbols (`PLN`, `USD`, `EUR`, `zl`, `$`, `€`) as well as overriden operators (`<`, `<=`, `>`, `>=`).

We can now see that these snippets of code are very readable to a non-programmer:
```
20(zl) as EUR
1000(USD) + 150(€)
5(zl) - 3(PLN) + 20.5(USD)
1(EUR) > 1(PLN)
1.5(€) * 10
```

The `CurrencyConverter` map can be painlessly modified to allow more currencies in the future.
