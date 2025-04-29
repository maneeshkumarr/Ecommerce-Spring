import React, { useState } from 'react';

const CartPage = () => {
  const [cartItems, setCartItems] = useState([]); // Replace with actual cart logic

  return (
    <div className="container mx-auto p-4">
      <h1 className="text-2xl font-bold mb-4">Your Cart</h1>
      {cartItems.length === 0 ? (
        <p>Your cart is empty.</p>
      ) : (
        <div className="grid grid-cols-1 gap-4">
          {cartItems.map((item) => (
            <div key={item.id} className="border p-4 rounded shadow">
              <h2 className="text-lg font-semibold">{item.name}</h2>
              <p className="text-gray-600">Quantity: {item.quantity}</p>
              <p className="text-green-500 font-bold">${item.price}</p>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default CartPage;