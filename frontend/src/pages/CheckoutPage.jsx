import React from 'react';

const CheckoutPage = () => {
  const handleCheckout = () => {
    // Add checkout logic here
    alert('Checkout successful!');
  };

  return (
    <div className="container mx-auto p-4">
      <h1 className="text-2xl font-bold mb-4">Checkout</h1>
      <button
        onClick={handleCheckout}
        className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600"
      >
        Confirm Checkout
      </button>
    </div>
  );
};

export default CheckoutPage;