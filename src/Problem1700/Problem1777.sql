SELECT
    product_id,
    SUM(if(store = 'store1', price, null)) as store1,
    SUM(if(store = 'store2', price, null)) as store2,
    SUM(if(store = 'store3', price, null)) as store3
FROM products
GROUP BY product_id