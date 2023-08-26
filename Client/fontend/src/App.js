
import './App.css';
import Home from './compoment/home';
import Product from './compoment/product';
import { Routes, Route } from 'react-router-dom';
function App() {
  return (
    <div className="App">
      <a href='/'>home --</a>
      <a href='/product'>product --</a>
      <a href='/cart'>cart</a>
      <Routes>
        <Route path='/' element={<Home/>}></Route>
        <Route path='/product' element={<Product/>}></Route>
      </Routes>
    </div>
  );
}

export default App;
