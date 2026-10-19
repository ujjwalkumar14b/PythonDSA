import heapq

if __name__ == "__main__":
    print("Heap/ Priority Queue")

    # Python's heapq is a min-heap by default.
    # To simulate a max-heap, we push negative values.
    pq = []

    heapq.heappush(pq, -3)
    heapq.heappush(pq, -2)
    heapq.heappush(pq, -1)
    heapq.heappush(pq, -4)
    heapq.heappush(pq, -5)

    # Display heap elements as positive numbers for readability
    print([-x for x in pq])

    # Remove the maximum element (smallest negative number)
    heapq.heappop(pq)

    print([-x for x in pq])
