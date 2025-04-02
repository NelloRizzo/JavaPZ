import OtherContact, { list } from './moduli'

for (var i = 0; i < list.length; ++i)
    console.log(list[i])

var c = new OtherContact("Paperon", "De' Paperoni", "333333")
console.log(c instanceof OtherContact)