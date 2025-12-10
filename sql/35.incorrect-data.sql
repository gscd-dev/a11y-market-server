UPDATE orders
   SET
   order_status = 'PENDING'
 WHERE order_status NOT IN ( 'PENDING',
                             'SHIPPED',
                             'DELIVERED',
                             'CANCELLED' );