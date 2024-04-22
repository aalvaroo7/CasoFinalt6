import java.util.Objects;

public class Pareja<T, U> {
    private T first;
    private U second;

    public Pareja(T first, U second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("Los elementos de la pareja no pueden ser nulos");
        }
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        if (first == null) {
            throw new IllegalArgumentException("El primer elemento de la pareja no puede ser nulo");
        }
        this.first = first;
    }

    public U getSecond() {
        return second;
    }

    public void setSecond(U second) {
        if (second == null) {
            throw new IllegalArgumentException("El segundo elemento de la pareja no puede ser nulo");
        }
        this.second = second;
    }

    @Override
    public String toString() {
        return "Pareja{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pareja<?, ?> pareja = (Pareja<?, ?>) obj;
        return first.equals(pareja.first) && second.equals(pareja.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}