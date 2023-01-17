make

export OMP_PLACES=cores 
export OMP_PROC_BIND=close
export OMP_DISPLAY_ENV=false

./affinity.o